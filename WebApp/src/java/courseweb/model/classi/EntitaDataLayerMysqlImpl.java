package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.data.DataLayerMysqlImpl;

/*
import courseweb.model.classi.entita;  //1 import per ogni classe
import it.univaq.f4i.iw.ex.newspaper.data.model.Author;
import it.univaq.f4i.iw.ex.newspaper.data.model.Image;
import it.univaq.f4i.iw.ex.newspaper.data.model.Issue;
import it.univaq.f4i.iw.ex.newspaper.data.model.NewsPaperDataLayer;
import it.univaq.f4i.iw.ex.newspaper.data.model.Article;
*/

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Giuseppe Della Penna
 */

/*
public class EntitaDataLayerMysqlImpl extends DataLayerMysqlImpl implements NewsPaperDataLayer {

    private PreparedStatement sImageByID, sArticleByID, sAuthors, sAuthorByID, sIssueByID;
    private PreparedStatement sArticles, sArticlesByIssue, sUnassignedArticles, sImagesByIssue, sImagesByArticle, sIssues, sGetLatestIssueNumber;
    private PreparedStatement sImageData;
    private PreparedStatement iArticle, uArticle, dArticle;
    private PreparedStatement iIssue, uIssue, dIssue;

    public EntitaDataLayerMysqlImpl(DataSource datasource) throws SQLException, NamingException {
        super(datasource);
    }

    @Override
    public void init() throws DataLayerException {
        try {
            super.init();

            //precompiliamo tutte le query utilizzate nella classe
            //precompile all the queries uses in this class
            sImageByID = connection.prepareStatement("SELECT * FROM image WHERE ID=?");
            sArticleByID = connection.prepareStatement("SELECT * FROM article WHERE ID=?");
            sAuthorByID = connection.prepareStatement("SELECT * FROM author WHERE ID=?");
            sAuthors = connection.prepareStatement("SELECT ID FROM author");
            sIssueByID = connection.prepareStatement("SELECT * FROM issue WHERE ID=?");
            sIssues = connection.prepareStatement("SELECT ID FROM issue");
            sGetLatestIssueNumber = connection.prepareStatement("SELECT MAX(number) AS number FROM issue");
            sArticlesByIssue = connection.prepareStatement("SELECT ID AS articleID FROM article WHERE issueID=?");
            sArticles = connection.prepareStatement("SELECT ID AS articleID FROM article");
            sUnassignedArticles = connection.prepareStatement("SELECT ID AS articleID FROM article WHERE issueID IS NULL");
            sImagesByIssue = connection.prepareStatement("SELECT article_image.imageID FROM article_image INNER JOIN article ON (article_image.articleID = article.ID) WHERE article.issueID=?");
            sImagesByArticle = connection.prepareStatement("SELECT imageID FROM article_image WHERE articleID=?");
            sImageData = connection.prepareStatement("SELECT data FROM image WHERE ID=?");

            //notare l'ultimo paametro extra di questa chiamata a
            //prepareStatement: lo usiamo per assicurarci che il JDBC
            //restituisca la chiave generata automaticamente per il
            //record inserito
            //note the last parameter in this call to prepareStatement:
            //it is used to ensure that the JDBC will sotre and return
            //the auto generated key for the inserted recors
            iArticle = connection.prepareStatement("INSERT INTO article (title,text,authorID,issueID,page) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            uArticle = connection.prepareStatement("UPDATE article SET title=?,text=?,authorID=?,issueID=?, page=? WHERE ID=?");
            dArticle = connection.prepareStatement("DELETE FROM article WHERE ID=?");

            iIssue = connection.prepareStatement("INSERT INTO issue (date,number) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            uIssue = connection.prepareStatement("UPDATE issue SET date=?,number=? WHERE ID=?");
            dIssue = connection.prepareStatement("DELETE FROM issue WHERE ID=?");

        } catch (SQLException ex) {
            throw new DataLayerException("Error initializing newspaper data layer", ex);
        }
    }

    //metodi "factory" che permettono di creare
    //e inizializzare opportune implementazioni
    //delle interfacce del modello dati, nascondendo
    //all'utente tutti i particolari
    //factory methods to create and initialize
    //suitable implementations of the data model interfaces,
    //hiding all the implementation details
    @Override
    public Author createAuthor() {
        return new AuthorImpl(this);
    }

    public Author createAuthor(ResultSet rs) throws DataLayerException {
        try {
            AuthorImpl a = new AuthorImpl(this);
            a.setKey(rs.getInt("ID"));
            a.setName(rs.getString("name"));
            a.setSurname(rs.getString("surname"));
            return a;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create author object form ResultSet", ex);
        }
    }

    @Override
    public Image createImage() {
        return new ImagelImpl(this);
    }

    public Image createImage(ResultSet rs) throws DataLayerException {
        ImagelImpl i = new ImagelImpl(this);
        try {
            i.setKey(rs.getInt("ID"));
            i.setImageSize(rs.getLong("size"));
            i.setCaption(rs.getString("caption"));
            i.setImageType(rs.getString("type"));
            i.setFilename(rs.getString("filename"));
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create image object form ResultSet", ex);
        }
        return i;
    }

    @Override
    public Article createArticle() {
        return new ArticleImpl(this);
    }

    public Article createArticle(ResultSet rs) throws DataLayerException {
        ArticleImpl a = new ArticleImpl(this);
        try {
            a.setKey(rs.getInt("ID"));
            a.setAuthorKey(rs.getInt("authorID"));
            a.setText(rs.getString("text"));
            a.setTitle(rs.getString("title"));
            a.setIssueKey(rs.getInt("issueID"));
            a.setPage(rs.getInt("page"));
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create article object form ResultSet", ex);
        }
        return a;
    }

    @Override
    public Issue createIssue() {
        return new IssueImpl(this);
    }

    public Issue createIssue(ResultSet rs) throws DataLayerException {
        try {
            IssueImpl i = new IssueImpl(this);

            i.setKey(rs.getInt("ID"));
            i.setNumber(rs.getInt("number"));
            i.setDate(rs.getDate("date"));
            return i;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create issue object form ResultSet", ex);
        }
    }

    public int getLatestIssueNumber() throws DataLayerException {

        try (
                ResultSet rs = sGetLatestIssueNumber.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("number");
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load author by ID", ex);
        }
        return 0;
    }

    @Override
    public Author getAuthor(int author_key) throws DataLayerException {
        try {
            sAuthorByID.setInt(1, author_key);
            try (ResultSet rs = sAuthorByID.executeQuery()) {
                if (rs.next()) {
                    //notare come utilizziamo il costrutture
                    //"helper" della classe AuthorImpl
                    //per creare rapidamente un'istanza a
                    //partire dal record corrente
                    //note how we use here the helper constructor
                    //of the AuthorImpl class to quickly
                    //create an instance from the current record
                    return createAuthor(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load author by ID", ex);
        }
        return null;
    }

    @Override
    public List<Author> getAuthors() throws DataLayerException {
        List<Author> result = new ArrayList();

        try (ResultSet rs = sAuthors.executeQuery()) {
            while (rs.next()) {
                result.add(getAuthor(rs.getInt("ID")));

            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load authors", ex);
        }
        return result;
    }

    @Override
    public Issue getIssue(int issue_key) throws DataLayerException {

        try {
            sIssueByID.setInt(1, issue_key);
            try (ResultSet rs = sIssueByID.executeQuery()) {
                if (rs.next()) {
                    return createIssue(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load issue by ID", ex);
        }

        return null;
    }

    @Override
    public List<Issue> getIssues() throws DataLayerException {
        List<Issue> result = new ArrayList();
        try (ResultSet rs = sIssues.executeQuery()) {
            while (rs.next()) {
                result.add(getIssue(rs.getInt("ID")));
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load issues", ex);
        }
        return result;
    }

    @Override
    public Article getArticle(int article_key) throws DataLayerException {

        try {
            sArticleByID.setInt(1, article_key);
            try (ResultSet rs = sArticleByID.executeQuery()) {
                if (rs.next()) {
                    return createArticle(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load article by ID", ex);
        }

        return null;
    }

    @Override
    public Image getImage(int image_key) throws DataLayerException {

        try {
            sImageByID.clearParameters();
            sImageByID.setInt(1, image_key);
            try (ResultSet rs = sImageByID.executeQuery()) {
                if (rs.next()) {
                    return createImage(rs);
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load image by ID", ex);
        }

        return null;
    }

    @Override
    public List<Image> getImages(Article article) throws DataLayerException {
        List<Image> result = new ArrayList();
        try {
            sImagesByArticle.setInt(1, article.getKey());
            try (ResultSet rs = sImagesByArticle.executeQuery()) {
                while (rs.next()) {
                    result.add(getImage(rs.getInt("ImageID")));
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load images by article", ex);
        }
        return result;
    }

//    @Override
//    public InputStream getImageData(int image_key) throws DataLayerException {
//        try {
//            sImageData.setInt(1, image_key);
//            try (ResultSet rs = sImageData.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getBinaryStream("data");
//                }
//
//            }
//        } catch (SQLException ex) {
//            throw new DataLayerException("Unable to load image data by ID", ex);
//        }
//        return null;
//    }

    @Override
    public List<Article> getArticles(Issue issue) throws DataLayerException {
        List<Article> result = new ArrayList();

        try {
            sArticlesByIssue.setInt(1, issue.getKey());
            try (ResultSet rs = sArticlesByIssue.executeQuery()) {
                while (rs.next()) {
                    result.add((Article) getArticle(rs.getInt("articleID")));
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load articles by issue", ex);
        }
        return result;
    }

    @Override
    public List<Article> getArticles() throws DataLayerException {
        List<Article> result = new ArrayList();

        try (ResultSet rs = sArticles.executeQuery()) {
            while (rs.next()) {
                result.add((Article) getArticle(rs.getInt("articleID")));
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load articles", ex);
        }
        return result;
    }

    @Override
    public List<Article> getUnassignedArticles() throws DataLayerException {
        List<Article> result = new ArrayList();

        try (ResultSet rs = sUnassignedArticles.executeQuery()) {
            while (rs.next()) {
                result.add((Article) getArticle(rs.getInt("articleID")));
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load unassigned articles", ex);
        }
        return result;
    }

    @Override
    public List<Image> getImages(Issue issue) throws DataLayerException {
        List<Image> result = new ArrayList();
        try {
            sImagesByIssue.setInt(1, issue.getKey());
            try (ResultSet rs = sImagesByIssue.executeQuery()) {
                while (rs.next()) {
                    result.add(getImage(rs.getInt("imageID")));
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load images by issue", ex);
        }
        return result;
    }

    @Override
    public void storeIssue(Issue issue) throws DataLayerException {
        //nota: con questo metodo assumiamo che gli articoli legati al numero
        //se modificati siano sottoposti a store separatamente
        //note: this method assumes that the linked articles, if modified,
        //are stored separately

        int key = issue.getKey();
        try {
            if (issue.getKey() > 0) { //update
                //non facciamo nulla se l'oggetto non ha subito modifiche
                //do not store the object if it was not modified
                if (!issue.isDirty()) {
                    return;
                }
                uIssue.setInt(2, issue.getNumber());
                uIssue.setDate(1, new java.sql.Date(issue.getDate().getTime()));
                uIssue.setInt(3, issue.getKey());
                uIssue.executeUpdate();
            } else { //insert
                iIssue.setInt(2, issue.getNumber());
                if (issue.getDate() != null) {
                    iIssue.setDate(1, new java.sql.Date(issue.getDate().getTime()));
                } else {
                    iIssue.setNull(1, java.sql.Types.DATE);
                }
                if (iIssue.executeUpdate() == 1) {
                    //per leggere la chiave generata dal database
                    //per il record appena inserito, usiamo il metodo
                    //getGeneratedKeys sullo statement.
                    //to read the generated record key from the database
                    //we use the getGeneratedKeys method on the same statement
                    try (ResultSet keys = iIssue.getGeneratedKeys()) {
                        //il valore restituito � un ResultSet con un record
                        //per ciascuna chiave generata (uno solo nel nostro caso)
                        //the returned value is a ResultSet with a distinct record for
                        //each generated key (only one in our case)
                        if (keys.next()) {
                            //i campi del record sono le componenti della chiave
                            //(nel nostro caso, un solo intero)
                            //the record fields are the key componenets
                            //(a single integer in our case)
                            key = keys.getInt(1);
                        }
                    }
                }
            }
            //restituiamo l'oggetto appena inserito RICARICATO
            //dal database tramite le API del modello. In tal
            //modo terremo conto di ogni modifica apportata
            //durante la fase di inserimento
            //we return the just-inserted object RELOADED from the
            //database through our API. In this way, the resulting
            //object will ambed any data correction performed by
            //the DBMS
            if (key > 0) {
                issue.copyFrom(getIssue(key));
            }
            issue.setDirty(false);
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to store issue", ex);
        }
    }

    @Override
    public void storeArticle(Article article) throws DataLayerException {
        int key = article.getKey();
        try {
            if (article.getKey() > 0) { //update
                //non facciamo nulla se l'oggetto non ha subito modifiche
                //do not store the object if it was not modified
                if (!article.isDirty()) {
                    return;
                }
                uArticle.setString(1, article.getTitle());
                uArticle.setString(2, article.getText());
                if (article.getAuthor() != null) {
                    uArticle.setInt(3, article.getAuthor().getKey());
                } else {
                    uArticle.setNull(3, java.sql.Types.INTEGER);
                }
                if (article.getIssue() != null) {
                    uArticle.setInt(4, article.getIssue().getKey());
                    uArticle.setInt(5, article.getPage());
                } else {
                    uArticle.setNull(4, java.sql.Types.INTEGER);
                    uArticle.setNull(5, java.sql.Types.INTEGER);
                }
                uArticle.setInt(6, article.getKey());
                uArticle.executeUpdate();
            } else { //insert
                iArticle.setString(1, article.getTitle());
                iArticle.setString(2, article.getText());
                if (article.getAuthor() != null) {
                    iArticle.setInt(3, article.getAuthor().getKey());
                } else {
                    iArticle.setNull(3, java.sql.Types.INTEGER);
                }
                if (article.getIssue() != null) {
                    iArticle.setInt(4, article.getIssue().getKey());
                    iArticle.setInt(5, article.getPage());
                } else {
                    iArticle.setNull(4, java.sql.Types.INTEGER);
                    iArticle.setNull(5, java.sql.Types.INTEGER);
                }
                if (iArticle.executeUpdate() == 1) {
                    //per leggere la chiave generata dal database
                    //per il record appena inserito, usiamo il metodo
                    //getGeneratedKeys sullo statement.
                    //to read the generated record key from the database
                    //we use the getGeneratedKeys method on the same statement
                    try (ResultSet keys = iArticle.getGeneratedKeys()) {
                        //il valore restituito � un ResultSet con un record
                        //per ciascuna chiave generata (uno solo nel nostro caso)
                        //the returned value is a ResultSet with a distinct record for
                        //each generated key (only one in our case)
                        if (keys.next()) {
                            //i campi del record sono le componenti della chiave
                            //(nel nostro caso, un solo intero)
                            //the record fields are the key componenets
                            //(a single integer in our case)
                            key = keys.getInt(1);
                        }
                    }
                }
            }
            //restituiamo l'oggetto appena inserito RICARICATO
            //dal database tramite le API del modello. In tal
            //modo terremo conto di ogni modifica apportata
            //durante la fase di inserimento
            //we return the just-inserted object RELOADED from the
            //database through our API. In this way, the resulting
            //object will ambed any data correction performed by
            //the DBMS
            if (key > 0) {
                article.copyFrom(getArticle(key));
            }
            article.setDirty(false);
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to store article", ex);
        }
    }

    @Override
    public void destroy() {
        //anche chiudere i PreparedStamenent � una buona pratica...
        //also closing PreparedStamenents is a good practice...
        try {
            sImageByID.close();
            sArticleByID.close();
            sAuthorByID.close();
            sAuthors.close();
            sIssueByID.close();
            sIssues.close();
            sGetLatestIssueNumber.close();
            sArticlesByIssue.close();
            sArticles.close();
            sUnassignedArticles.close();
            sImagesByIssue.close();
            sImagesByArticle.close();
            sImageData.close();

            iArticle.close();
            uArticle.close();
            dArticle.close();

            iIssue.close();
            uIssue.close();
            dIssue.close();
        } catch (SQLException ex) {
            //
        }
        super.destroy();
    }
}

*/