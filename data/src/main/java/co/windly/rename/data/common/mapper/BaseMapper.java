package co.windly.rename.data.common.mapper;

import android.support.annotation.NonNull;
import org.modelmapper.ModelMapper;

public abstract class BaseMapper {

  //region Constructor

  public BaseMapper(@NonNull ModelMapper mapper) {
    this.mapper = mapper;
  }

  //endregion

  //region Model Mapper

  protected ModelMapper mapper;

  //endregion
}
