
package TAG;

import java.util.Date;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Yerke
 */
public class DisplayDate extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println((" "+new Date()).substring(0,11));
        } catch (Exception ex) {
            throw new JspException("Error in DisplayDate tag", ex);
        }
    }
    
}
