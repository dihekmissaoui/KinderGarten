package tn.esprit.spring.service.impl;

import tn.esprit.spring.repository.ReactionRepository;
import tn.esprit.spring.service.ReactionService;

import tn.esprit.spring.entity.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Reaction}.
 */
@Service
@Transactional
public class ReactionServiceImpl implements ReactionService {

    private final Logger log = LoggerFactory.getLogger(ReactionServiceImpl.class);

    private final ReactionRepository reactionRepository;

    public ReactionServiceImpl(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Reaction save(Reaction reaction) {
        log.debug("Request to save Reaction : {}", reaction);
        return reactionRepository.save(reaction);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reaction> findAll() {
        log.debug("Request to get all Reactions");
        return reactionRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Reaction> findOne(Long id) {
        log.debug("Request to get Reaction : {}", id);
        return reactionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reaction : {}", id);
        reactionRepository.deleteById(id);
    }
}
