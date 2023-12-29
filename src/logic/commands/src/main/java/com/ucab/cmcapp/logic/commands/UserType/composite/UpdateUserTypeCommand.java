package com.ucab.cmcapp.logic.commands.UserType.composite;


import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.UserType.atomic.UpdateUserTypeByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateUserTypeCommand extends Command<UserType>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateUserTypeCommand.class );
    private UserType _user;
    private UserType _result;
    private UpdateUserTypeByIdCommand _addUserTypeCommand;

    public UpdateUserTypeCommand(UserType user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteUserTypeCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteUserTypeCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteUserTypeCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addUserTypeCommand = CommandFactory.createUpdateUserTypeByIdCommand(_user, getHandler());
            _addUserTypeCommand.execute();
            _result = _addUserTypeCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteUserTypeCommand.execute");
        //endregion
    }

    @Override
    public UserType getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}

