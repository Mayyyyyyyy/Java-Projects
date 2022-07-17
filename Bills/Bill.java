package Bills;
public class Bill {
    public int id;
    public String type;
    public String content;
    public float amount;
    public String time;

    public Bill(int id, String type, String content, float amount, String time) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.amount = amount;
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
    
    public float getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }
}

