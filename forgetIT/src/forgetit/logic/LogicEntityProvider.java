package forgetit.logic;

import java.util.List;



import forgetit.common.Date;
import forgetit.common.Entity;
import forgetit.common.Tag;
import forgetit.logic.entity.LogicEntityProviderInternal;
import forgetit.logic.interfaces.ILogicInternalEntityProvider;


/**
 * 
 * @author David Henn
 * @date 1.3.2011
 * Implementation of ILogicEntityProvider
 * @see ILogicEntityProvider
 *
 */
public class LogicEntityProvider implements ILogicEntityProvider {
	
	private ILogicInternalEntityProvider internalEntityProvider;
	public LogicEntityProvider(){
		internalEntityProvider = new LogicEntityProviderInternal();
	}

	@Override
	public List<Entity> getEntities() {
		return internalEntityProvider.getEntities();
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate) {
		return internalEntityProvider.getEntities(startDate, endDate);
	}

	@Override
	public List<Entity> getEntities(Date startDate, Date endDate, List<Tag> tags) {
		return internalEntityProvider.getEntities(startDate, endDate, tags);
	}

	@Override
	public List<Entity> getEntities(List<Tag> tags) {
		return internalEntityProvider.getEntities(tags);
	}

}
