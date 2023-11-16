package com.example.alesiaproj.repository;

import com.example.alesiaproj.entity.Task;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class FirebaseTaskRepository {
    public String create(Task task) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference docRef = firestore.collection("task").document();
        task.setId(docRef.getId());
        ApiFuture<WriteResult> collection = docRef.set(task);
        return collection.get().getUpdateTime().toString();
    }

    public Optional<Task> getById(String documentId) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("task").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();

        if (documentSnapshot.exists()) {
            return Optional.of(documentSnapshot.toObject(Task.class));
        }
        return Optional.empty();
    }
    public List<Task> getByUserEmail(String email){
        Firestore firestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = firestore.collection("task");

        Query query = collectionReference.whereEqualTo("worker", email);

        ApiFuture<QuerySnapshot> future = query.get();
        QuerySnapshot querySnapshot;

        try {
            querySnapshot = future.get();
        } catch (InterruptedException | ExecutionException e) {

            e.printStackTrace();
            return Collections.emptyList();
        }

        List<Task> taskList = new ArrayList<>();

        for (QueryDocumentSnapshot document : querySnapshot) {
            taskList.add(document.toObject(Task.class));
        }

        return taskList;
    }
    public String deleteById(String documentId) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = firestore.collection("task").document(documentId).delete();
        return "OK " + documentId;
    }

    public String update(Task task) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = firestore.collection("task").document(task.getId()).set(task);
        return future.get().getUpdateTime().toString();
    }

    public List<Task> getAll() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = firestore.collection("task");

        ApiFuture<QuerySnapshot> future = collectionReference.get();
        QuerySnapshot querySnapshot = future.get();

        List<Task> taskList = new ArrayList<>();

        for (QueryDocumentSnapshot document : querySnapshot) {
            taskList.add(document.toObject(Task.class));
        }

        return taskList;
    }
}
