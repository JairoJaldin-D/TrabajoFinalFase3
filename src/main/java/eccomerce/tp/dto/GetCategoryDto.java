package eccomerce.tp.dto;

public class GetCategoryDto {

    private Long id;
    private String name;

    public GetCategoryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GetCategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
