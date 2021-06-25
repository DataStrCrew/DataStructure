package com.datastrcrew.libraryapi.service;

import com.datastrcrew.libraryapi.entity.HasID;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/**
 * The admin service for the database communication.
 * 
 * @author Kasim
 */
public class GenericService<E extends HasID> {
    /** Firestore database object. */
    private Firestore dbFirestore = FirestoreClient.getFirestore();
    /** Name of the collection in the database. */
    private String collection;
    /** Class of the element. */
    private Class<E> clazz;
    /** Mapper for mapping the received hashmaps to classes. */
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Constructor of the class.
     * 
     * @param clazz      class of the element.
     * @param collection name of the collection in the database.
     */
    public GenericService(Class<E> clazz, String collection) {
        this.collection = collection;
        this.clazz = clazz;
    }

    /**
     * Retrieves the element with the given id from the database.
     * 
     * @param e the id of the element to be retrieved.
     * @return the element if found, null otherwise.
     * @throws ExecutionException   on error.
     * @throws InterruptedException on error.
     */
    public E get(E e) throws ExecutionException, InterruptedException {
        // Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> future = dbFirestore.collection(collection).document(e.getID()).get();
        DocumentSnapshot document = future.get();
        Object doc = document.getData();
        if (document.exists()) {
            E element = mapper.convertValue(doc, clazz);
            return element;
        } else {
            return null;
        }
    }

    /**
     * Retrieves all the elements from the database.
     * 
     * @return a list of elements.
     * @throws ExecutionException   on error.
     * @throws InterruptedException on error.
     */
    public ArrayList<E> getAll() throws ExecutionException, InterruptedException {
        // Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection(collection).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();
        ArrayList<E> eList = new ArrayList<E>();
        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot document = future.get();
            Object doc = document.getData();
            E e = mapper.convertValue(doc, clazz);
            eList.add(e);
        }
        return eList;
    }

    /**
     * Saves the given element to the database.
     * 
     * @param e the element to be saved.
     * @return success message.
     * @throws ExecutionException   on error.
     * @throws InterruptedException on error.
     */
    public boolean save(E e) throws ExecutionException, InterruptedException {
        // Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(collection).document(e.getID()).set(e);
        return true;
    }

    /**
     * Saves the given array of elements to the database.
     * 
     * @param elements the array of elements to be saved.
     * @return success message.
     * @throws ExecutionException   on error.
     * @throws InterruptedException on error.
     */
    public boolean saveAll(ArrayList<E> elements) throws ExecutionException, InterruptedException {
        // Firestore dbFirestore = FirestoreClient.getFirestore();
        for (E e : elements)
            dbFirestore.collection(collection).document(e.getID()).set(e);
        return true;
    }

    /**
     * Removes the given element from the database.
     * 
     * @param e id of the element to be removed.
     * @return success message.
     * @throws ExecutionException   on error.
     * @throws InterruptedException on error.
     */
    public boolean delete(E e) throws ExecutionException, InterruptedException {
        // Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(collection).document(e.getID()).delete();
        return true;
    }

    /**
     * Removes the given array of elements from the database.
     * 
     * @return success message.
     * @throws ExecutionException   on error.
     * @throws InterruptedException on error.
     */
    public boolean deleteAll() throws ExecutionException, InterruptedException {
        // Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterator<DocumentReference> documentRIterator = dbFirestore.collection(collection).listDocuments().iterator();
        while (documentRIterator.hasNext()) {
            DocumentReference documentReference = documentRIterator.next();
            documentReference.delete();
        }
        return true;
    }
}