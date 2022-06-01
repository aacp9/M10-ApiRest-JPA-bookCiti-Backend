package cl.acabrera.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.acabrera.ServletInitializer;
import cl.acabrera.VO.BooksVO;
import cl.acabrera.model.Books;
import cl.acabrera.repository.BooksRepository;
@Service
public class BooksServiceImpl implements BooksService {

	private static final Logger log=LoggerFactory.getLogger(ServletInitializer.class);
	
	@Autowired
	BooksRepository bookRespository;
	
	cl.acabrera.VO.BooksVO respuesta;

	@Override
	@Transactional(readOnly = true)
	public BooksVO findAllByTitleContainingIgnoreCase(String titleTest) {
		respuesta=new BooksVO(new ArrayList<Books>(),"ha ocurrido un error","101");
		try {
			List<Books> books = bookRespository.findAllByTitleContainingIgnoreCase(titleTest);
			if(books.size()>0) {
				respuesta.setBooks(books);
				respuesta.setMensaje("Libros encontrados correctamente.");
				respuesta.setCodigo("0");
			}else {
				respuesta.setMensaje("Libro no encontrado");
			}
		} catch (Exception e) {
			log.trace("Books Service: Error en findAllByTitleContainingIgnoreCase",e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public BooksVO findAll() {
		respuesta=new BooksVO(new ArrayList<Books>(),"ha ocurrido un error","102");
		try {
			List<Books> books = bookRespository.findAll();
			if(books.size()>0) {
				respuesta.setBooks(books);
				respuesta.setMensaje("Lista de libros disponibles...");
				respuesta.setCodigo("0");
			}else {
				respuesta.setMensaje("Lista de Libros vacia.");
			}
		} catch (Exception e) {
			log.trace("Books Service: Error en findAll",e);
		}
		return respuesta;

	}

	@Override
	@Transactional
	public BooksVO save(Books book) {
		respuesta=new BooksVO(new ArrayList<Books>(),"ha ocurrido un error","103");
		try {
			bookRespository.save(book);
			respuesta.setMensaje(String.format("se ha guardado correctamente el libro %s",book.getTitle()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Books Service: Error en save",e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public BooksVO delete(Books book) {
		respuesta=new BooksVO(new ArrayList<Books>(),"ha ocurrido un error","104");
		try {
			bookRespository.delete(book);
			respuesta.setMensaje("se ha eliminado correctamente el libro.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Books Service: Error en delete",e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public BooksVO update(Books book) {
		respuesta=new BooksVO(new ArrayList<Books>(),"ha ocurrido un error","105");
		try {
			bookRespository.save(book);
			respuesta.setMensaje(String.format("se ha actualizado correctamente el libro %s",book.getTitle()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Books Service: Error en update",e);
		}
		return respuesta;
		
	}

	@Override
	@Transactional(readOnly = true)
	public BooksVO findByIdBook(int idBook) {
		respuesta=new BooksVO(new ArrayList<Books>(),"ha ocurrido un error","106");
		try {
			Books books = bookRespository.findByIdBook(idBook);
			respuesta.getBooks().add(books);
			respuesta.setMensaje("libro encontrado correctamente.");
			respuesta.setCodigo("0");
			
		} catch (Exception e) {
			log.trace("Books Service: Error en findByIdBook",e);
		}
		return respuesta;
	}
	
	
	

}
