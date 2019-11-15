package co.poligran.sw_recycleview;

public class Episode {
    String title;
    String id;
    String opening_crawl;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public Episode(String title, String id, String opening_crawl) {
        this.title = title;
        this.id = "Episode ";
        if(id.equals("1"))
            this.id += "I";;
        if(id.equals("2"))
            this.id += "II";;
        if(id.equals("3"))
            this.id += "III";;
        if(id.equals("4"))
            this.id += "IV";;
        if(id.equals("5"))
            this.id += "V";;
        if(id.equals("6"))
            this.id += "VI";
        if(id.equals("7"))
            this.id += "VI";


        this.opening_crawl = opening_crawl;
    }
}
