package ch.teko.contact.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jonathan on 19.06.17.
 */

@Entity
public class Contact {
    @Id
    private Long id;

    @NotNull
    private String name;

    @Generated(hash = 646261587)
    public Contact(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 672515148)
    public Contact() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
