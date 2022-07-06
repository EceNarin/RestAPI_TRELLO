package api.trellopojos;

public class RequestForList {

     private String  key ;
     private String  token;
     private String  name;
     private String  idBoard;


    public RequestForList(String key, String token, String name, String idBoard) {
        this.key = key;
        this.token = token;
        this.name = name;
        this.idBoard = idBoard;
    }

    @Override
    public String toString() {
        return "RequestForList{" +
                "key='" + key + '\'' +
                ", token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", idList='" + idBoard + '\'' +
                '}';
    }
}
