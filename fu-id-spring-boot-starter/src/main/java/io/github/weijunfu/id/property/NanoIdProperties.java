package io.github.weijunfu.id.property;

import io.github.weijunfu.id.utils.Constant;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Nano ID
 * @author ijunfu
 * @version 1.0.0
 *
 */
@ConfigurationProperties(prefix = "fu.nano")
public class NanoIdProperties {

    private int size = 21;

    private String alphabet = Constant.ALPHABET64;

    private boolean enabled = false;

    public NanoIdProperties() {
    }

    public NanoIdProperties(int size, String alphabet) {
        this.size = size;
        this.alphabet = alphabet;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "NanoIdProperties{" +
                "size=" + size +
                ", alphabet='" + alphabet + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
