package cl.acabrera.service;

import java.util.List;

import cl.acabrera.model.Books;

public interface BooksService {
	public void save(Books book);
	public void update(Books book);
	public void delete(Books book);
	public List<Books> findAllByTitleContainingIgnoreCase(String titleTest);
	public List<Books> findAll();
	public Books findByIdBook(int idBook);
}
