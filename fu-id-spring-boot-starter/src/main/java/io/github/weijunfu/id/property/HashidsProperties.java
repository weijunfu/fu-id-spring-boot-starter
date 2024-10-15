package io.github.weijunfu.id.property;

import io.github.weijunfu.id.utils.Constant;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Hashids 配置类
 * @author ijunfu
 * @version 1.0.0
 *
 */
@ConfigurationProperties(prefix = "fu.hashids")
public class HashidsProperties {

    private boolean enabled = false;
    private int size = 16;
    private String salt = ".29i12jun17fu_";
    private String alphabet = Constant.ALPHABET62;

    public HashidsProperties() {}

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String toString() {
        return "HashidsProperties{" +
                "enabled=" + enabled +
                ", size=" + size +
                ", salt='" + salt + '\'' +
                ", alphabet='" + alphabet + '\'' +
                '}';
    }
}
