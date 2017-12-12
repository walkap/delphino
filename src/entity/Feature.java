package entity;

public class Feature {

    private String name;
    private String description;


    /**
     * Constructor
     *
     * @param name     - Feature's name
     * @param description - Feature's description
     */
    public Feature(String name, String description) {
        this.name = name;
        this.description = description;


    }


    /**
     * Get the Feature's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }


    /**
     * Set the feature's name
     *
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get the feature's description
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }


    /**
     * Set the feature's description
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
