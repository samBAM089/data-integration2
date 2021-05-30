import java.util.List;
import java.util.Objects;


public class JobItem {
    private String link;
    private String author;
    private List<String> categories;
    private String title;
    private String description;
    private String pubDate;
    private String updated;
    private String location;

    public JobItem(String link, String author, List<String> categories, String title, String description, String pubDate, String updated, String location) {

        this.link = link;
        this.author = author;
        this.categories = categories;
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.updated = updated;
        this.location = location;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobItem jobItem = (JobItem) o;
        return Objects.equals(link, jobItem.link) && Objects.equals(author, jobItem.author) && Objects.equals(categories, jobItem.categories) && Objects.equals(title, jobItem.title) && Objects.equals(description, jobItem.description) && Objects.equals(pubDate, jobItem.pubDate) && Objects.equals(updated, jobItem.updated) && Objects.equals(location, jobItem.location);
    }

    @Override
    public String toString() {
        return "JobItem{" +
                " link='" + link + '\'' +
                ", author='" + author + '\'' +
                ", categories=" + categories +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", updated='" + updated + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, author, categories, title, description, pubDate, updated, location);
    }
}
