package domain.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class User {

    @Id
    @Column(name = "userid")
    private String userid;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    //private String salt;
    private boolean enabled=true;
    

    
    
    @OneToMany(targetEntity = Purchase.class, fetch = FetchType.EAGER)
    private Map<Long, Purchase> purchases;
    
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRole> roles;
    
    

    public User(String userid, String email, String hashedPassword, String firstName, String lastName, String salt, String role) {
        setUserid(userid);
        setEmail(email);
//        setSalt(salt);
        setPassword(hashedPassword);
        setFirstName(firstName);
        setLastName(lastName);
        setRoles(roles);
        
        //setRole(role);

    }
    public List<UserRole> getRoles() {
        if(this.roles==null){
            this.roles = new ArrayList<>();
        }
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//	public String getRole() {
//		return role.toString();
//	}
//
//	public void setRole(String rolestring) {
//		if(rolestring.isEmpty()){
//			throw new IllegalArgumentException("Role may not be empty/null.");
//		}
//		this.role = role.valueOf(rolestring.toUpperCase());
//	}
    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        if (userid.isEmpty()) {
            throw new ModelException("No userid given");
        }
        this.userid = userid;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new ModelException("No email given");
        }
        String USERID_PATTERN
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new ModelException("Email not valid");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

//    public boolean isPasswordCorrect(String password) {
//        if (password.isEmpty()) {
//            throw new ModelException("Password may not be empty.");
//        }
//
//        return this.hashPassword(password).equals(this.password);
//    }

    public void setPassword(String password) {
//        if (password == null || password.isEmpty()) {
//            throw new ModelException("Password may not be empty.");
//        } else {
//            setHashedPassword(hashPassword(password));
//        }
        this.password=password;
    }

    public void setHashedPassword(String hashedpassword) {
        if (hashedpassword == null || hashedpassword.isEmpty()) {
            throw new ModelException("Password may not be empty.");
        } else {
            this.password = hashedpassword;
        }
    }


//    private String hashPassword(String password) {
//        MessageDigest crypt = null;
//        try {
//            crypt = MessageDigest.getInstance("SHA-1");
//        } catch (NoSuchAlgorithmException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        crypt.reset();
//        // salt
//        byte[] seed = new byte[20];
//        if (this.getSalt() == null || this.getSalt().isEmpty()) {
//            SecureRandom random = new SecureRandom();
//            seed = random.generateSeed(20);
//            this.setSalt(Base64.getEncoder().encodeToString((seed)));
//
//        } else {
//            seed = Base64.getDecoder().decode(this.getSalt());
//        }
//        crypt.update(seed);
//        try {
//            crypt.update(password.getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return new BigInteger(1, crypt.digest()).toString(16);
//    }


//    public String getSalt() {
//        return salt;
//    }
//
//    public void setSalt(String salt) {
//        if (salt == null || salt.isEmpty()) {
//            throw new ModelException("Salt may not be null/empty.");
//        } else {
//            this.salt = salt;
//        }
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new ModelException("No firstname given");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new ModelException("No last name given");
        }
        this.lastName = lastName;
    }

    public Map<Long, Purchase> getPurchases() {
        if(this.purchases==null){
            this.purchases = new HashMap<>();
        }
        return purchases;
    }

    public void setPurchases(Map<Long, Purchase> purchases) {
        if(purchases==null){
            throw new ModelException("Purchases was null");
        }
        this.purchases = purchases;
    }
}
