package Comment_model;

import Profile_model.Profile;
import User_model.User;
import model.Item;

/**
 *
 * @author Yerke
 */
public class Comment extends Item{
    private Profile toProfile;
    private User fromUser;
    private String content;
    
    public Comment(){}
    public  Comment(int id){
        super(id);
    }
    public Comment(int id, Profile profile, User user, String content){
        super(id);
        this.toProfile = profile;
        this.fromUser = user;
        this.content = content;
    }


    public Profile getToProfile() {
        return toProfile;
    }

    public void setToProfile(Profile toProfile) {
        this.toProfile = toProfile;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
