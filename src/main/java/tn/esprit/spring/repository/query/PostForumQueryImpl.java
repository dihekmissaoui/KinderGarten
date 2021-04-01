package tn.esprit.spring.repository.query;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.PostForum;
import tn.esprit.spring.entity.PostForumFilter;

@Service
@Transactional
public class PostForumQueryImpl implements PostForumQuery{
	
	@Autowired
	EntityManager em;

	@Override
	public Page<PostForum> findPostforumByFilter(PostForumFilter postForumFilter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostForum> cq = cb.createQuery(PostForum.class);
		Root<PostForum> root = cq.from(PostForum.class);
		ArrayList<Predicate> predicates = new ArrayList<>();
		if(postForumFilter != null && postForumFilter.getTitle() != null){
			predicates.add(cb.like(cb.lower(root.get("title")),"%"+postForumFilter.getTitle()+"%"));
		}
		
		
		if(postForumFilter != null && postForumFilter.getMinCreationDate() != null){
			predicates.add(cb.greaterThanOrEqualTo(root.get("creationDate"), postForumFilter.getMinCreationDate()));
			
		}
		if(postForumFilter != null && postForumFilter.getMaxCreaionDate() != null){
			predicates.add(cb.lessThanOrEqualTo(root.get("creationDate"), postForumFilter.getMaxCreaionDate()));
			
		}
		
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		cq.orderBy(cb.desc(root.get("creationDate")));
		TypedQuery<PostForum> query = em.createQuery(cq);
		long count = query.getResultList().size();
		query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		return new PageImpl<>(query.getResultList(),pageable,count);
		// TODO Auto-generated method stub
		
	}

}
