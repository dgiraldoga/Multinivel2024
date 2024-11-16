package co.banco.mio.bancomio;

import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.repository.CardRepository;
import co.banco.mio.bancomio.service.impl.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {
    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardServiceImpl cardService;

    private Optional<Card> card;

    @Test
    void testInactivateCard() {
        // Configurar la tarjeta para que ya esté en estado ACTIVO
        card= cardRepository.findById(1961180);

        // Llamar al método y verificar que lanza una excepción
        Exception exception = assertThrows(Exception.class, () -> {
            cardService.inactivateCard(card.get().getSerialCard());
        });
    }
}
