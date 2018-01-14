package entity;

import java.io.Serializable;

public class Feature implements Serializable {

    private String name;
    private String description;

    private static final long serialVersionUID = 1L;

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

    public Feature(String name){
        this.name = name;
    }

    public boolean isEqualTo(Feature f) {

        if (f == null){
            return false;
        }
        if (this.name.equalsIgnoreCase(f.getName()) &&
                this.description.equalsIgnoreCase(f.getDescription())){
            return true;
        }
        return false;
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
