package med.util;

import med.model.Visit;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterGraphics;

public class FilePrinter implements Printable {
    private Visit visit;

    int[] pageBreaks;  // array of page break line positions.

    /* Synthesise some sample lines of text */
    String[] textLines;

//    public void setVisit(Visit visit) {
//        this.visit = visit;
//    }

    public FilePrinter(Visit visit) {
        this.visit = visit;
    }

    //TODO update
    private void initTextLines() {
        if (textLines == null) {
            int numLines = 200;
            textLines = new String[numLines];
            for (int i = 0; i < numLines; i++) {
                textLines[i] = "This is line number " + i + "\t" + visit.getName();
            }
        }
    }

    /**
     * Prints the page at the specified index into the specified
     * {@link Graphics} context in the specified
     * format.  A <code>PrinterJob</code> calls the
     * <code>Printable</code> interface to request that a page be
     * rendered into the context specified by
     * <code>graphics</code>.  The format of the page to be drawn is
     * specified by <code>pageFormat</code>.  The zero based index
     * of the requested page is specified by <code>pageIndex</code>.
     * If the requested page does not exist then this method returns
     * NO_SUCH_PAGE; otherwise PAGE_EXISTS is returned.
     * The <code>Graphics</code> class or subclass implements the
     * {@link PrinterGraphics} interface to provide additional
     * information.  If the <code>Printable</code> object
     * aborts the print job then it throws a {@link PrinterException}.
     *
     * @param graphics   the context into which the page is drawn
     * @param pageFormat the size and orientation of the page being drawn
     * @param pageIndex  the zero based index of the page to be drawn
     * @return PAGE_EXISTS if the page is rendered successfully
     * or NO_SUCH_PAGE if <code>pageIndex</code> specifies a
     * non-existent page.
     * @throws PrinterException thrown when the print job is terminated.
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        System.out.println("File printer: print " + pageIndex);

        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null) {
            initTextLines();
            int linesPerPage = (int) (pageFormat.getImageableHeight() / lineHeight);
            int numBreaks = (textLines.length - 1) / linesPerPage;
            pageBreaks = new int[numBreaks];
            for (int b = 0; b < numBreaks; b++) {
                pageBreaks[b] = (b + 1) * linesPerPage;
            }
        }
        System.out.println("File printer: printing");

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         */
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         */
        int y = 0;
        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
        int end = (pageIndex == pageBreaks.length)
                ? textLines.length : pageBreaks[pageIndex];
        for (int line = start; line < end; line++) {
            y += lineHeight;
            graphics.drawString(textLines[line], 0, y);
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
}
