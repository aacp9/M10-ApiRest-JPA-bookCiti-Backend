package cl.acabrera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor //constructor con parámetros
@NoArgsConstructor	//constructor sin parametros
@SequenceGenerator(name="SQ_BOOK", initialValue=1, allocationSize=1,sequenceName = "SQ_BOOK")

public class Books {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_BOOK")
	@Column(name="id_book")
	private int idBook;
	private String title;
	private String author;
	private String location;
}
