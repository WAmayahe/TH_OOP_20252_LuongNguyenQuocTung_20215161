package hust.soict.elite.aims.media;
import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Định nghĩa hằng số bộ so sánh dùng chung toàn hệ thống
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return title != null && title.equalsIgnoreCase(media.title);
    }

    @Override
    public String toString() {
        return "Media [ID=" + id + ", Title=" + title + ", Category=" + category + ", Cost=" + cost + "$]";
    }
}