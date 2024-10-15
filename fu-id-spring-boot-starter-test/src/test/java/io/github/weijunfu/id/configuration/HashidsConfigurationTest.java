package io.github.weijunfu.id.configuration;

import io.github.weijunfu.id.utils.Hashids;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Hashids Test
 * @author ijunfu
 * @version 1.0.0
 *
 */
@SpringBootTest
public class HashidsConfigurationTest {

    @Resource
    private Hashids hashids;

    @DisplayName("Hashids")
    @Test
    void hashids() {
        long id = 1845896192316280832L;

        String encoded = hashids.encode(id);
        Assertions.assertNotNull(encoded);

        long[] decoded = hashids.decode(encoded);
        Assertions.assertEquals(1, decoded.length);

        Assertions.assertEquals(id, decoded[0]);
    }

}
