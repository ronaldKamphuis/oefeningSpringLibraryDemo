package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.storage;

public class StorageFileNotFoundException extends com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.storage.StorageException {

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
