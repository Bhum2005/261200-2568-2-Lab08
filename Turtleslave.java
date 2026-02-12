public class Turtleslave implements Runnable{


    private Turtle name;
    private String job;
    public Turtleslave(Turtle chue, String ngan){
        this.job=ngan;
        this.name=chue;
    }
    @Override
    public void run() {
        if(this.job.equals("Sun")){
            drawSun(0,0);
        }
        if(this.job.equals("Moon")){
            drawMoon(200,0,"White");
        }
        if(this.job.equals("Eclipse")){
            drawEclipse(-220,0,"Black");
        }
    }
    private void drawSun(int x,int y){
        this.name.up();
        this.name.setPosition(x, y);
        this.name.down();
        int rayLength = 50;
        int sunRadius = 40;
        this.name.width(2);
        this.name.speed(1);

        for (int i = 0; i < 72; i++) {

            if (i % 3 == 0) this.name.penColor("Red");
            else if (i % 3 == 1) this.name.penColor("Orange");
            else this.name.penColor("Yellow");

            this.name.up();
            this.name.forward(sunRadius);
            this.name.down();


            int currentRay = (i % 2 == 0) ? rayLength : rayLength + 20;
            this.name.forward(currentRay);

            this.name.up();
            this.name.backward(sunRadius + currentRay);
            this.name.left(360.0 / 72.0);
        }
    }
    private void drawMoon(int x,int y,String color){
        this.name.up();
        this.name.setPosition(x, y);
        int moonRadius = 60; // Size of the moon
        this.name.speed(1);
        this.name.width(1);
        this.name.down();
        this.name.up();
        this.name.setPosition(x, y);
        this.name.penColor("Yellow");
        this.name.down();

        for (int i = 0; i < 360; i++) {
            this.name.forward(moonRadius);
            this.name.backward(moonRadius);
            this.name.left(1);
        }
        this.name.up();
        this.name.setPosition(x+20, y+10);
        this.name.penColor(color);
        this.name.down();

        for (int i = 0; i < 360; i++) {
            this.name.forward(moonRadius);
            this.name.backward(moonRadius);
            this.name.left(1);
        }
    }
    private void drawEclipse(int x, int y,String color){
        drawSun(x,y);
        drawMoon(x,y,color);
    }
}
