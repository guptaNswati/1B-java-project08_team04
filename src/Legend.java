import java.awt.Color;

/**
 * One object of type Legend holds a country name of type String and an object
 * of type color that represents the corresponding color.
 * @author Team04
 */
public class Legend {

    private String countryName;
    private Color legendColor;

    /**
     * Constructs a legend key that contains the country name and color of one
     * country.
     * 
     * @param countryName  name of the country
     * @param legendColor  color of the graphed data points
     */
    public Legend(String countryName, Color legendColor) {
        this.countryName = countryName;
        this.legendColor = legendColor;
    }

    /**
     * returns legendColor
     * @return legendColor color of graphed data points
     */
    public Color getLegendColor() {
        return legendColor;
    }
    
    /**
     * Sets the value of legendColor.
     * @param legendColor color of graphed data points
     */
    public void setLegendColor(Color legendColor) {
        this.legendColor = legendColor;
    }

    /**
     * Returns countryName
     * @return  countryName name of country
     */
    public String getCountryName() {
        return countryName;
    }
}

