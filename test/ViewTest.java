import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import GUI.controller.GUIController;
import GUI.view.IView;
import GUI.view.ViewListener;
import model.IImageDataBase;
import model.ImageDataBase;

import static org.junit.Assert.assertEquals;

/**
 * The type Mock view.
 */
class MockView implements IView {
  /**
   * The Image to test.
   */
  public BufferedImage imageToTest;
  private final StringBuilder log;

  /**
   * Instantiates a new Mock view.
   *
   * @param log the log
   */
  public MockView(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void renderImage(BufferedImage image) {
    this.imageToTest = image;
    StringBuilder imageString = new StringBuilder();
    for (int x = 0; x < this.imageToTest.getWidth(); x++) {
      for (int y = 0; y < this.imageToTest.getHeight(); y++) {
        Color color = new Color(this.imageToTest.getRGB(x, y));

        imageString.append(color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "\n");
      }
    }
    this.log.append("renderImage: " + imageString);
  }

  @Override
  public void addViewListener(ViewListener listener) {
    this.log.append("addViewListener called");
  }

  @Override
  public void setVisible(boolean value) {
    this.log.append("setVisible called with value: " + value);
  }

  /**
   * Gets log.
   *
   * @return the log
   */
  public String getLog() {
    return this.log.toString();
  }
}

/**
 * The type View test.
 */
public class ViewTest {

  /**
   * Test valid ppm load.
   */
  @Test
  public void testValidPPMLoad() {
    IImageDataBase model = new ImageDataBase();
    StringBuilder log = new StringBuilder();
    MockView mockView = new MockView(log);

    ViewListener controller = new GUIController(model, mockView);

    controller.handleLoadEvent("res/tomato-soup.ppm");

    String expectedString = "234,226,215\n" +
            "234,226,215\n" +
            "233,225,214";

    String[] lines = mockView.getLog().split("\n");

    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 3, lines.length));

    assertEquals(expectedString, lastMsg);
  }

  /**
   * Test valid png load.
   */
  @Test
  public void testValidPNGLoad() {
    IImageDataBase model = new ImageDataBase();
    StringBuilder log = new StringBuilder();
    MockView mockView = new MockView(log);

    ViewListener controller = new GUIController(model, mockView);

    controller.handleLoadEvent("res/Picasso.png");

    String expectedString = "235,218,185\n" +
            "236,216,185\n" +
            "236,217,187";

    String[] lines = mockView.getLog().split("\n");

    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 3, lines.length));

    assertEquals(expectedString, lastMsg);
  }

  /**
   * Test valid jpg load.
   */
  @Test
  public void testValidJPGLoad() {
    IImageDataBase model = new ImageDataBase();
    StringBuilder log = new StringBuilder();
    MockView mockView = new MockView(log);

    ViewListener controller = new GUIController(model, mockView);

    controller.handleLoadEvent("res/dog.jpg");

    String expectedString = "126,129,100\n" +
            "99,99,71\n" +
            "106,106,78";

    String[] lines = mockView.getLog().split("\n");

    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 3, lines.length));

    assertEquals(expectedString, lastMsg);
  }
}