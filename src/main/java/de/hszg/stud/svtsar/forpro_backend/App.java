package de.hszg.stud.svtsar.forpro_backend;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
	public static void main(String[] args) {
		new App();
	}

	public App() {
		register(JacksonFeature.class);
		packages("de.hszg.stud.svtsar.forpro_backend.resource");
		/*
		 * EntityManagerFactory factory =
		 * Persistence.createEntityManagerFactory("forpro"); EntityManager entityManager
		 * = factory.createEntityManager();
		 */

		/*
		 * Product_rep productRepository = new Product_rep(); Category_rep
		 * categoryRepository = new Category_rep();
		 * 
		 * Category testCat = new Category(); testCat.setName("testName");
		 * 
		 * Product testProduct = new Product(); testProduct.setName("productNameToday");
		 * testProduct.setPrice(10.0); testProduct.setCategory(testCat);
		 * 
		 * categoryRepository.create(testCat); productRepository.create(testProduct);
		 */

		/*
		 * entityManager.getTransaction().begin();
		 * 
		 * entityManager.persist(testCat); entityManager.persist(testProduct);
		 * 
		 * entityManager.getTransaction().commit(); entityManager.close();
		 * factory.close();
		 */
	}
}
