package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import tn.esprit.spring.entity.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "subCategory")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "posts")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<PostForum> postForums = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "categories", allowSetters = true)
    private Category subCategory;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Category categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Category addCategory(Category category) {
        this.categories.add(category);
        category.setSubCategory(this);
        return this;
    }

    public Category removeCategory(Category category) {
        this.categories.remove(category);
        category.setSubCategory(null);
        return this;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<PostForum> getPostForums() {
        return postForums;
    }

    public Category postForums(Set<PostForum> postForums) {
        this.postForums = postForums;
        return this;
    }

    public Category addPostForum(PostForum postForum) {
        this.postForums.add(postForum);
        postForum.setPosts(this);
        return this;
    }

    public Category removePostForum(PostForum postForum) {
        this.postForums.remove(postForum);
        postForum.setPosts(null);
        return this;
    }

    public void setPostForums(Set<PostForum> postForums) {
        this.postForums = postForums;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public Category subCategory(Category category) {
        this.subCategory = category;
        return this;
    }

    public void setSubCategory(Category category) {
        this.subCategory = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", categoryName='" + getCategoryName() + "'" +
            "}";
    }
}
