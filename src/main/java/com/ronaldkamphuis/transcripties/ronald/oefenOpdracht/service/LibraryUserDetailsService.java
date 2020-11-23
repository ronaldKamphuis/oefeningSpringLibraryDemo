package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.service;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel:
 */

@Service
public class LibraryUserDetailsService implements UserDetailsService {

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return libraryUserRepository.findByUsername(s).orElseThrow(
                () -> new UsernameNotFoundException("Gebruikersnaam " + s + " is niet gevonden.")
        );
    }
}
