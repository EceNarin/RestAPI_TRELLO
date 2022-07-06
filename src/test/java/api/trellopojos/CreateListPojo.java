package api.trellopojos;

public class CreateListPojo {

    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Integer pos;
    private Limits limits;

    public CreateListPojo() {
    }

    public CreateListPojo(String id, String name, Boolean closed, String idBoard, Integer pos, Limits limits) {
        super();
        this.id = id;
        this.name = name;
        this.closed = closed;
        this.idBoard = idBoard;
        this.pos = pos;
        this.limits = limits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "CreateListPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", idBoard='" + idBoard + '\'' +
                ", pos=" + pos +
                ", limits=" + limits +
                '}';
    }
}