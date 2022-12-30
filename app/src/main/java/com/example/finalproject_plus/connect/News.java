package com.example.finalproject_plus.connect;

import java.util.Date;
import java.util.List;

public class News {
    private String status;
    private String source;
    private String sortBy;
    private List<Articles> articles;
    News(){

    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getSource() {
        return this.source;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
    public String getSortBy() {
        return this.sortBy;
    }
    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }
    public List<Articles> getArticles() {
        return this.articles;
    }

    public class Articles {
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private Date publishedAt;

        public Articles() {

        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getUrlToImage() {
            return this.urlToImage;
        }

        public void setPublishedAt(Date publishedAt) {
            this.publishedAt = publishedAt;
        }

        public Date getPublishedAt() {
            return this.publishedAt;
        }
    }
}
