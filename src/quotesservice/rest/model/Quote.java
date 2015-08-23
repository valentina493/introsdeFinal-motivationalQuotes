package quotesservice.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import quotesservice.rest.dao.MyDatabaseDao;

@Entity  // indicates that this class is an entity to persist in DB
@Table(name="quotes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "_id", "author", "quoteText"})
public class Quote implements Serializable{
	private static final long serialVersionUID = 3114067158037546506L;

	@Id
	@GeneratedValue(generator = "sqlite_quotes")
	@TableGenerator(name = "sqlite_quotes", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "quotes")
	@Column(name = "_id")
	private long _id;
	
	@Column(name = "quote")
	private String quoteText;
	
	@Column(name = "author")
	private String author;

	@XmlElement(name = "id")
	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	@XmlElement(name = "sentence")
	public String getQuoteText() {
		return quoteText;
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	@XmlElement(name = "author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public static Quote findQuote(long id) {
		EntityManager em = MyDatabaseDao.instance.createEntityManager();
		Quote q = em.find(Quote.class, id);
		MyDatabaseDao.instance.closeConnections(em);
		return q;
	}
	
}
