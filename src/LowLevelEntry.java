
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.*;

public class LowLevelEntry implements GLEventListener {

    private double theta = 0.05;

    public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("Teste 001");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(new LowLevelEntry());

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        //animator.add(canvas);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        update();
        render(drawable);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }

    private void update() {
        //theta += 0.01;
    }

    private void render(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glRotatef( (float)theta, 0.0f, 1.0f, 0.0f );

        // draw a triangle filling the window
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1, 0, 0);
            gl.glVertex2d(0, 1);

            gl.glColor3f(0, 1, 0);
            gl.glVertex2d(-1, -1);

            gl.glColor3f(0, 0, 1);
            gl.glVertex2d( 1, -1);
        gl.glEnd();
    }
}
