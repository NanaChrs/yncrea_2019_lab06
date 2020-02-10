package yncrea.lab06.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yncrea.lab06.core.dao.ReviewDAO;
import yncrea.lab06.core.dao.TagDAO;

@Service
@Transactional
public class TagService {
    private TagDAO tagDAO;

    public TagService(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }
}
