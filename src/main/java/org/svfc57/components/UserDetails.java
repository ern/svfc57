package org.svfc57.components;

import org.apache.tapestry5.MarkupWriter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserDetails {

    boolean beginRender( MarkupWriter writer ) throws Exception {

        Authentication currentUser = null;
        currentUser = SecurityContextHolder.getContext().getAuthentication();

        if ( null != currentUser ) {

            writer.write( currentUser.getName() );
        }
        else {

            writer.write( "<NO-NAME-SPECIFIED>" );
        }
        return true;
    }

}
