package cl.acabrera.service;

import java.util.List;

import cl.acabrera.VO.BooksVO;
import cl.acabrera.model.Books;

public interface BooksService {
	public BooksVO save(Books book);
	public BooksVO update(Books book);
	public BooksVO delete(Books book);
	public BooksVO findAllByTitleContainingIgnoreCase(String titleTest);
	public BooksVO findAll();
	public BooksVO findByIdBook(int idBook);

//	public void save(Books book);
//	public void update(Books book);
//	public void delete(Books book);
//	public List<Books> findAllByTitleContainingIgnoreCase(String titleTest);
//	public List<Books> findAll();
//	public Books findByIdBook(int idBook);
}
