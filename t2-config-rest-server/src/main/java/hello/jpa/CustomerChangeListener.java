package hello.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CustomerChangeListener extends AbstractRepositoryEventListener<Customer> {

    Logger logger = LoggerFactory.getLogger(CustomerChangeListener.class);

    @Override
    protected void onBeforeCreate(Customer entity) {
        logger.info("onBeforeCreate");
    }

    @Override
    protected void onAfterCreate(Customer entity) {
        logger.info("onAfterCreate");
    }

    @Override
    public void onBeforeSave(Customer entity) {
        logger.info("onBeforeSave");
    }

    @Override
    public void onAfterSave(Customer entity) {
        logger.info("onAfterSave");
    }

    @Override
    protected void onBeforeLinkSave(Customer parent, Object linked) {
        logger.info("onBeforeLinkSave");
    }

    @Override
    protected void onAfterLinkSave(Customer parent, Object linked) {
        logger.info("onAfterLinkSave");
    }

    @Override
    protected void onBeforeLinkDelete(Customer parent, Object linked) {
        logger.info("onBeforeLinkDelete");
    }

    @Override
    protected void onAfterLinkDelete(Customer parent, Object linked) {
        logger.info("onAfterLinkDelete");
    }

    @Override
    protected void onBeforeDelete(Customer entity) {
        logger.info("onBeforeDelete");
    }

    @Override
    protected void onAfterDelete(Customer entity) {
        logger.info("onAfterDelete");
    }
}