public class Background extends Graph {
    protected String texture;
    protected Colors color;

    public Background() {
    }

    public Background(Colors color, String texture) {
        this.color = color;
        this.texture = texture;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Colors getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }

    @Override
    public void draw() {
        System.out.println("Background with color: " + color + " and texture: " + texture);
    }
}
