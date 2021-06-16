package projetspring.sport.service;
import java.util.List;

import org.springframework.data.domain.Page;
import projetspring.sport.model.subscriber;

public interface subscriberServiceInterface {
    List<subscriber> getAllSubscriber();
    void saveSubscriber(subscriber subscriber);
    subscriber getSubscriberById(long id);
    void deleteSubscriberById(long id);
    Page<subscriber> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
