package co.windly.rename.data.persistence.mapper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import co.windly.rename.data.common.mapper.BaseMapper;
import co.windly.rename.data.domain.model.book.Character;
import co.windly.rename.data.network.dto.response.book.CharacterData;
import co.windly.rename.data.persistence.database.entity.book.CharacterEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;

import static io.reactivex.Observable.fromIterable;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

public class CharacterMapper extends BaseMapper {

  //region Constructor

  @Inject
  public CharacterMapper(@NonNull ModelMapper mapper) {
    super(mapper);
  }

  //endregion

  //region CharacterData -> CharacterEntity -> Character

  private CharacterEntity mapCharacterDataToEntity(@NonNull CharacterData data) {
    return mapper.map(data, CharacterEntity.class);
  }

  public List<CharacterEntity> mapCharacterDatasToEntities(@Nullable List<CharacterData> datas) {
    return fromIterable(defaultIfNull(datas, new ArrayList<>()))
      .map(this::mapCharacterDataToEntity)
      .toList()
      .blockingGet();
  }

  private Character mapCharacterEntityToModel(@NonNull CharacterEntity entity) {
    return mapper.map(entity, Character.class);
  }

  public List<Character> mapCharacterEntitiesToModels(@Nullable List<CharacterEntity> entities) {
    return fromIterable(defaultIfNull(entities, new ArrayList<>()))
      .map(this::mapCharacterEntityToModel)
      .toList()
      .blockingGet();
  }

  //endregion
}
