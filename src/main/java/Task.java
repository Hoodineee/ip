public class Task {
    protected String description;
    protected boolean isDone;
    protected DateFormat date;

    public void isMark(boolean bool) {
        this.isDone = bool;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDate(String str) {
        this.date = new DateFormat(str);
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String toString() {
        return date.toString();
    }
}

