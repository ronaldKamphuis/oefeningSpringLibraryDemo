package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.service;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.Partij;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.PartijRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel:
 */
public class PartijService implements PartijRepository {

    @Override
    public Optional<Partij> findByTitel(String titel) {
        return Optional.empty();
    }

    @Override
    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "/partijen/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    @Override
    public List<Partij> findAll() {
        return null;
    }

    @Override
    public List<Partij> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Partij> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Partij> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Partij partij) {

    }

    @Override
    public void deleteAll(Iterable<? extends Partij> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Partij> S save(S s) {
        return null;
    }

    @Override
    public <S extends Partij> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Partij> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Partij> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Partij> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Partij getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Partij> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Partij> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Partij> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Partij> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Partij> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Partij> boolean exists(Example<S> example) {
        return false;
    }
}
