package cl.acabrera.VO;

import java.util.List;

import cl.acabrera.model.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BooksVO extends GenericVO{
	
	List<Books> books;

	public BooksVO(List<Books> books, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.books=books;
	}
}
