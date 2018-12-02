namespace java io.owen.woodpecker.common.thrift


typedef i64 long 
typedef i32 int 

service WoodpeckerService {
	long registerAgent(),
	void start(),

}
