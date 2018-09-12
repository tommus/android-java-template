package co.windly.rename.data.domain;

import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import org.modelmapper.ModelMapper;

@Module
public class DomainModule {

  //region Model Mapper

  @Provides
  @NonNull
  ModelMapper provideModelMapper() {
    final ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setAmbiguityIgnored(true);
    mapper.getConfiguration().setSkipNullEnabled(true);
    return mapper;
  }

  //endregion
}
