package cl.acabrera.service;

import java.util.List;

import cl.acabrera.model.Books;

public interface BooksService {
	void save(Books book);
	void update(Books book);
	void delete(Books book);
	List<Books> findAllByTitle(String titleTest);
	List<Books> findAll();
}
