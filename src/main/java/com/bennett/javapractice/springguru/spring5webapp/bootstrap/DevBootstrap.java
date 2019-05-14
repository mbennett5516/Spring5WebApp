package com.bennett.javapractice.springguru.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.bennett.javapractice.springguru.spring5webapp.model.Author;
import com.bennett.javapractice.springguru.spring5webapp.model.Book;
import com.bennett.javapractice.springguru.spring5webapp.model.Publisher;
import com.bennett.javapractice.springguru.spring5webapp.repositories.AuthorRepository;
import com.bennett.javapractice.springguru.spring5webapp.repositories.BookRepository;
import com.bennett.javapractice.springguru.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Publisher harperCollins = new Publisher("Harper Collins", "123 streetName");
		Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(harperCollins);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("Worx", "123 avenueName");
		Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(worx);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
}
